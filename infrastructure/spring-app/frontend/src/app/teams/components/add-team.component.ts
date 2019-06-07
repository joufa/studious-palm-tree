import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-team',
  templateUrl: 'add-team.component.html',
  styles: [`
  .example-container {
    display: flex;
    flex-direction: column;
  }
  .example-container > * {
    width: 100%;
  }
  `]
})
export class AddTeamComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  onSubmit() {
  }

}
