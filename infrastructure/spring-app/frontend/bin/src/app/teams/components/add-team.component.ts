import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Team, TeamDTO, TeamOperationType } from '../models/team';

@Component({
  selector: 'app-add-team',
  templateUrl: 'add-team.component.html',
  styles: [
    `
      mat-card-title,
      mat-card-content,
      mat-card-footer {
        display: flex;
        justify-content: center;
      }

      .mat-form-field {
        width: 100%;
        min-width: 300px;
      }
    `
  ]
})
export class AddTeamComponent implements OnInit {
  @Output() submitted = new EventEmitter<TeamDTO>();

  @Input() team: Team;
  form: FormGroup = new FormGroup({
    type: new FormControl('0'),
    name: new FormControl(''),
    memberCount: new FormControl('1'),
    desc: new FormControl('')
  });
  constructor() {}

  ngOnInit() {
    console.log(this.team);
    if (this.team) {
      this.form = new FormGroup({
        type: new FormControl('1'),
        name: new FormControl(this.team.name),
        memberCount: new FormControl(this.team.memberCount),
        desc: new FormControl(this.team.description)
      });
    }
  }

  isValid() {
    return this.form.valid;
  }

  // 0 = create, 1 = update, 2 = delete
  validate(deleting: boolean): TeamDTO {
    let type;
    if (deleting) {
      type = TeamOperationType.DELETE;
    } else {
      type =
        this.form.get('type').value === '0'
          ? TeamOperationType.CREATE
          : TeamOperationType.UPDATE;
    }
    const desc = this.form.get('desc').value;
    const members = +this.form.get('memberCount').value;
    return {
      operation: type,
      teamId: this.team ? this.team.teamId : null,
      name: this.form.get('name').value,
      memberCount: members,
      description: desc ? desc : null
    };
  }

  delete() {
    this.submitted.emit(this.validate(true));
  }
  onSubmit() {
    if (this.form.valid) {
      this.submitted.emit(this.validate(false));
    }
  }
}
