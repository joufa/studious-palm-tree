import { Component, Input } from '@angular/core';
import { Team } from '../models/team';

@Component({
  selector: 'app-team-list',
  template: `
    <app-team-card *ngFor="let team of teams" [team]="team"></app-team-card>
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
}
