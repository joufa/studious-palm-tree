// Feature reducer

import { Action, combineReducers, createFeatureSelector, createSelector } from '@ngrx/store';
import * as fromRoot from '../../store/reducers';
import * as fromTeams from './teams.reducer';
import { Team } from '../models/team';


export interface TeamsState {
    teams: fromTeams.State;
}

export interface State extends fromRoot.State {
    teams: TeamsState;
}

// AOT friendly
export function reducers(state: TeamsState | undefined, action: Action) {
  return combineReducers({
    teams: fromTeams.reducer
  })(state, action);
}

export const getTeamsState = createFeatureSelector<State, TeamsState>('teams');

export const getTeamEntitiesState = createSelector(
    getTeamsState,
    state => state.teams
  );
export const getSelectedTeamId = createSelector(
    getTeamEntitiesState,
    fromTeams.getSelectedTeamId
  );


export const {
    selectIds: getTeamIds,
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
