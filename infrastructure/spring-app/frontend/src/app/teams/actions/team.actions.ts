import { createAction, props } from '@ngrx/store';
import { Team, TeamDTO } from '../models/team';
import { Update } from '@ngrx/entity';

export const loadTeams = createAction('[Team] Load teams');

export const loadTeamsSuccess = createAction(
  '[Team] Load teams success',
  props<{ teams: Team[] }>()
);

export const createTeam = createAction(
  '[Team] Create a team',
  props<{ team: TeamDTO }>()
);

export const createTeamSuccess = createAction(
  '[Team] Create team success',
  props<{ team: Team }>()
);

export const updateTeam = createAction(
  '[Team] Update a team',
  props<{ team: TeamDTO }>()
);

export const updateTeamSuccess = createAction(
  '[Team] Update team success',
  props<{ team: Team }>()
);

export const deleteTeam = createAction(
  '[Team] Delete a team',
  props<{ team: TeamDTO }>()
);

export const deleteTeamSuccess = createAction(
  '[Team] Delete team success',
  props<{ team: Team }>()
);

export const teamFailure = createAction(
  '[Team] Failure on team operation',
  props<{ error: Error }>()
);

export const selectTeam = createAction(
  '[Team] Select a team',
  props<{ teamId: string }>()
);
