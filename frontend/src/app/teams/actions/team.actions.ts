import { createAction, union, props } from '@ngrx/store';
import { Team } from '../models/team';

export const loadTeams = createAction(
    '[Team] Load teams'
);

export const loadTeamsSuccess = createAction(
    '[Team] Load teams success',
    props<{ teams: Team[] }>()
);

const all = union({loadTeams, loadTeamsSuccess});
export type TeamActionsUnion = typeof all;
