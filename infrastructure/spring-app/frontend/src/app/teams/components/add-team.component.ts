import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { TeamDTO } from '../models/team';

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

  form: FormGroup = new FormGroup({
    name: new FormControl(''),
    memberCount: new FormControl('1'),
    desc: new FormControl('')
  });
  constructor() { }

  ngOnInit() {
  }

  isValid() {
    return this.form.valid;
  }
  debug() {
    return JSON.stringify(this.form);
  }
  validate(): TeamDTO {
    const desc = this.form.get('desc').value;
    const members = +(this.form.get('memberCount').value);
    return { name: this.form.get('name').value, memberCount: members, description: desc ? desc : null };

  }
  onSubmit() {
    if (this.form.valid) {
      this.submitted.emit(this.validate());
    }
  }
}
