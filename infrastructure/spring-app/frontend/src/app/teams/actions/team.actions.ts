import { createAction, union, props } from '@ngrx/store';
import { Team } from '../models/team';
import { Update } from '@ngrx/entity';

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

export const updateTeam = createAction(
    '[Team] Update a team',
    props<{team: Team}>()
);

export const updateTeamSuccess = createAction(
    '[Team] Update team success',
    props<{team: Update<Team>}>()
);

export const deleteTeam = createAction(
    '[Team] Delete a team',
    props<{team: Team}>()
);

export const deleteTeamSuccess = createAction(
    '[Team] Delete team success',
    props<{team: Team}>()
);

const all = union({loadTeams,
    loadTeamsSuccess,
    createTeam,
    createTeamSuccess,
    updateTeam,
    updateTeamSuccess,
    deleteTeam,
    deleteTeamSuccess});
export type TeamActionsUnion = typeof all;
