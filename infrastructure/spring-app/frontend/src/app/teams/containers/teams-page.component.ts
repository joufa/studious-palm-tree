import { Component, ChangeDetectionStrategy, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { Observable } from 'rxjs';

import * as fromTeams from '../../teams/reducers';
import { Team } from '../models/team';
import { loadTeams } from '../actions/team.actions';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-teams-page',
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `
    <mat-card>
      <mat-card-title>Tiimit</mat-card-title>
    </mat-card>
  <button routerLink="team" class="fab-absolute" mat-fab>
    <mat-icon class="icon">add</mat-icon>
  </button>
    <app-team-list [teams]="teams$ | async" (navigateTo)="navigate($event)"></app-team-list>
  `,
  styles: [`
  mat-card-title {
    display: flex;
    justify-content: center;
  }

  .fab-absolute {
    position: fixed;
    bottom: 1rem;
    right: 1rem;
  }

  @media(min-width: 1024px) {
     .fab-absolute {
      bottom: 1.5rem;
      right: 1.5rem;
    }
  }
  `]
})
export class TeamsPageComponent implements OnInit {
  teams$: Observable<Team[]>;

  constructor(private store: Store<fromTeams.State>, private router: Router) {
    this.teams$ = this.store.pipe(select(fromTeams.getAllTeams));
  }

  ngOnInit() {
    this.store.dispatch(loadTeams);
  }

  navigate(event: any) {
    this.router.navigate(['admin/team/' + event]);
  }
}
