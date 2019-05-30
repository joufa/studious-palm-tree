import { Injectable } from '@angular/core';
import { Actions, Effect, ofType } from '@ngrx/effects';
import { Action } from '@ngrx/store';
import { Observable } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { TeamsApiService } from '../../core/services/teams.service';
import {
    TeamActions
} from '../actions';
import { Team } from '../models/team';

@Injectable()
export class TeamEffects {


  @Effect()
  loadTeams$: Observable<Action> = this.actions$.pipe(
    ofType(TeamActions.loadTeams.type),
    switchMap(() =>
      this.service.getTeams().pipe(
        map((teams: Team[]) =>
          TeamActions.loadTeamsSuccess({ teams })
        )
      )
    )
  );

  constructor(
    private actions$: Actions<TeamActions.TeamActionsUnion>,
    private service: TeamsApiService
  ) {}
}
