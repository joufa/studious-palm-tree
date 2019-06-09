import { EntityState, EntityAdapter, createEntityAdapter } from '@ngrx/entity';
import { Team } from '../models/team';
import { TeamActions } from '../actions';
import { createReducer, on } from '@ngrx/store';

export interface State extends EntityState<Team> {
  selectedTeamId: string | null;
}

export const adapter: EntityAdapter<Team> = createEntityAdapter<Team>({
  selectId: (team: Team) => team.teamId,
  sortComparer: false
});

export const initialState: State = adapter.getInitialState({
  selectedTeamId: null
});

export const reducer = createReducer(
  initialState,
  on(TeamActions.loadTeamsSuccess, (state, { teams }) =>
    adapter.addMany(teams, state)
  ),
  on(TeamActions.createTeamSuccess, (state, { team }) =>
    adapter.addOne(team, state)
  )
);

export const getSelectedId = (state: State) => state.selectedTeamId;
