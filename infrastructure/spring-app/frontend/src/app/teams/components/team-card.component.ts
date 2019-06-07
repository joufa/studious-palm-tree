import { Component, OnInit, Input } from '@angular/core';
import { Team } from '../models/team';

@Component({
  selector: 'app-team-card',
  template: `
  <mat-card>
  <mat-card-header>
    <mat-card-title>{{team.name}}</mat-card-title>
  </mat-card-header>
  <mat-card-content>
  <ul>
    <li>{{team.teamId}}</li>
    <li>{{team.memberCount}}</li>
    <li>{{team.description}}</li>
  </ul>
  </mat-card-content>
  <mat-card-actions>
    <button mat-button>MUOKKAA</button>
  </mat-card-actions>
</mat-card>
  `,
  styles: []
})
export class TeamCardComponent implements OnInit {

  @Input()
  team: Team;

  ngOnInit() {
  }

}
