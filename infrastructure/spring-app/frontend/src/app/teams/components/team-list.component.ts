import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Team } from '../models/team';


@Component({
  selector: 'app-team-list',
  template: `
    <app-team-card *ngFor="let team of teams" [team]="team" (navigate)="navigate($event)"></app-team-card>
  `,
  styles: [
    `
      :host {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
      }
    `,
  ],
})
export class TeamListComponent {
  @Input() teams: Team[];
  @Output() navigateTo = new EventEmitter<string>();
  navigate(event: any) {
   this.navigateTo.emit(event);
  }
}
