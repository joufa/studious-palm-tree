import { EntityState, EntityAdapter, createEntityAdapter } from '@ngrx/entity';
import { Team } from '../models/team';
import { TeamActions } from '../actions';
import { generateMockTeam } from '../models/team';

export interface State extends EntityState<Team> {
    selectedTeamId: string | null;
}

export const adapter: EntityAdapter<Team> = createEntityAdapter<Team>({
    selectId: (team: Team) => team.teamId,
    sortComparer: false,
});

export const initialState: State = adapter.getInitialState({
    selectedTeamId: null,
});

export function reducer(
    state = initialState,
    action: TeamActions.TeamActionsUnion
): State {
    switch (action.type) {
        case TeamActions.loadTeamsSuccess.type:
            return adapter.addMany(action.teams, state);
        case TeamActions.createTeamSuccess.type:
            return adapter.addOne(action.team, state);
        case TeamActions.updateTeamSuccess.type:
            return adapter.updateOne(action.team, state);
        case TeamActions.deleteTeamSuccess.type:
            return adapter.removeOne(action.team.teamId, state);
        default:
            return state;
    }
}

export const getSelectedId = (state: State) => state.selectedTeamId;
