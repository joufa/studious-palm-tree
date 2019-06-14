import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of } from 'rxjs';
import { catchError, map, mergeMap, switchMap, tap } from 'rxjs/operators';
import { TeamsApiService } from '../../core/services/teams.service';
import { TeamActions } from '../actions';
import { Team } from '../models/team';

@Injectable()
export class TeamEffects {
  loadTeams$ = createEffect(() =>
    this.actions$.pipe(
      ofType(TeamActions.loadTeams.type),
      switchMap(() =>
        this.service
          .getTeams()
          .pipe(map((teams: Team[]) => TeamActions.loadTeamsSuccess({ teams })))
      )
    )
  );

  createTeam$ = createEffect(() =>
    this.actions$.pipe(
      ofType(TeamActions.createTeam.type),
      mergeMap(({ team }) =>
        this.service.createTeam(team).pipe(
          map((createdTeam: Team) => TeamActions.createTeamSuccess({ team: createdTeam })),
          catchError(() => of(TeamActions.teamFailure))
        )
      )
    )
  );

  updateTeam$ = createEffect(() =>
  this.actions$.pipe(
    ofType(TeamActions.updateTeam.type),
    mergeMap(({ team }) =>
      this.service.updateTeam(team).pipe(
        map((updatedTeam: Team) => TeamActions.updateTeamSuccess({team: updatedTeam })),
        catchError(() => of(TeamActions.teamFailure))
      )
    )
  )
);

deleteTeam$ = createEffect(() =>
  this.actions$.pipe(
    ofType(TeamActions.deleteTeam.type),
    mergeMap(({ team }) =>
      this.service.deleteTeam(team).pipe(
        map((deletedTeam: Team) => TeamActions.deleteTeamSuccess({team: deletedTeam })),
        catchError(() => of(TeamActions.teamFailure))
      )
    )
  )
);

updateTeamSuccess$ = createEffect(() =>
this.actions$.pipe(
  ofType(TeamActions.updateTeamSuccess.type),
  tap(() => this.router.navigate(['admin']))),
{dispatch: false}
);

  createTeamSuccess$ = createEffect(() =>
          this.actions$.pipe(
            ofType(TeamActions.createTeamSuccess.type),
            tap(() => this.router.navigate(['admin']))),
          {dispatch: false}
  );

  deleteTeamSuccess$ = createEffect(() =>
  this.actions$.pipe(
    ofType(TeamActions.deleteTeamSuccess.type),
    tap(() => this.router.navigate(['admin']))),
  {dispatch: false}
);


  constructor(private actions$: Actions, private service: TeamsApiService, private router: Router) {}
}
