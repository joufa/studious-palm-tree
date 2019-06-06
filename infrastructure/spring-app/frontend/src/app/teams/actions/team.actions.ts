import { createAction, union, props } from '@ngrx/store';
import { Team } from '../models/team';

export const loadTeams = createAction(
    '[Team] Load teams'
);

export const loadTeamsSuccess = createAction(
    '[Team] Load teams success',
    props<{ teams: Team[] }>()
);

export const createTeam = createAction(
    '[Team] Create a team',
    props<{team: Team}>()
);

export const createTeamSuccess = createAction(
    '[Team] Create team success',
    props<{team: Team}>()
);

const all = union({loadTeams, loadTeamsSuccess, createTeam, createTeamSuccess});
export type TeamActionsUnion = typeof all;
