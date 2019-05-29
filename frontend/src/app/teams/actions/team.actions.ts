import { createAction } from '@ngrx/store';

export const loadTeams = createAction(
    '[Team] Load teams'
);

export type TeamActionsUnion = ReturnType<typeof loadTeams>;
