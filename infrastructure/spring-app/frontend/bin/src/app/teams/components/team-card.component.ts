import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Team } from '../models/team';

@Component({
  selector: 'app-team-card',
  template: `
    <mat-card *ngIf="team">
      <mat-card-header>
        <mat-card-title>{{ name }}</mat-card-title>
      </mat-card-header>
      <mat-card-content> </mat-card-content>
      <mat-card-actions>
        <button mat-button (click)="navigateTo()">MUOKKAA</button>
      </mat-card-actions>
    </mat-card>
  `,
  styles: [
    `
      :host {
        display: flex;
      }
      mat-card {
        width: 400px;
        margin: 15px;
        display: flex;
        flex-flow: column;
        justify-content: space-between;
      }

      @media only screen and (max-width: 768px) {
        mat-card {
          margin: 15px 0 !important;
        }
      }
      mat-card:hover {
        box-shadow: 3px 3px 16px -2px rgba(0, 0, 0, 0.5);
      }
    `
  ]
})
export class TeamCardComponent {
  @Input()
  team: Team;

  @Output()
  navigate = new EventEmitter<string>();

  get name() {
    return this.team.name;
  }

  get id() {
    return this.team.teamId;
  }

  get desc() {
    return this.team.description;
  }

  get memberCount() {
    return this.team.memberCount;
  }

  navigateTo() {
    this.navigate.emit(this.team.teamId.toString());
  }
}
