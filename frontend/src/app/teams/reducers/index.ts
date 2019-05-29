import {
    createSelector,
    createFeatureSelector,
    ActionReducerMap,
} from '@ngrx/store';

import * as fromTeams from './teams.reducer';
import * as fromRoot from '../../store/reducers';

export interface TeamsState {
    teams: fromTeams.State;
}

export interface State extends fromRoot.State {
    teams: TeamsState;
}

export const reducers: ActionReducerMap<TeamsState, any> = {
    teams: fromTeams.reducer,
};


export const getTeamsState = createFeatureSelector<State, TeamsState>('teams');


export const getTeamEntitiesState = createSelector(
    getTeamsState,
    state => state.teams
);

export const getSelectedTeamId = createSelector(
    getTeamEntitiesState,
    fromTeams.getSelectedId
);

export const {
    selectIds: getTeamsIds,
    selectEntities: getTeamEntities,
    selectAll: getAllTeams,
    selectTotal: getTotalTeams,
} = fromTeams.adapter.getSelectors(getTeamEntitiesState);

export const getSelectedTeam = createSelector(
    getTeamEntities,
    getSelectedTeamId,
    (entities, selectedId) => {
        return selectedId && entities[selectedId];
    }
);
