import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-team',
  template: `
  <div class="example-container">
  <mat-form-field>
  <input matInput placeholder="Input">
</mat-form-field>

</div>
  `,
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

}
