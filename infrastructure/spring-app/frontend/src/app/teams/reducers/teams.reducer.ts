import { createEntityAdapter, EntityAdapter, EntityState, Update } from '@ngrx/entity';
import { createReducer, on } from '@ngrx/store';
import { TeamActions } from '../actions';
import { Team } from '../models/team';

export interface State extends EntityState<Team> {
  selectedTeamId: string | null;
}

export function sortByName(a: Team, b: Team): number {
  return a.name.localeCompare(b.name);
}

export const adapter: EntityAdapter<Team> = createEntityAdapter<Team>({
  selectId: (team: Team) => team.teamId,
  sortComparer: sortByName
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
  ),
  on(TeamActions.updateTeamSuccess, (state, { team }) =>
    adapter.updateOne(generateUpdate(team), state)
  ),
  on(TeamActions.deleteTeamSuccess, (state, { team }) =>
    adapter.removeOne(team.teamId, state)
  ),
  on(TeamActions.selectTeam, (state, { teamId }) => ({
    ...state,
    selectedTeamId: teamId
  }))
);

function generateUpdate(team: Team): Update<Team> {
  return {
    id: team.teamId,
    changes: {
      name: team.name,
      memberCount: team.memberCount,
      description: team.description,
      createdAt: team.createdAt,
      updatedAt: team.updatedAt
    }
  };
}

export const getSelectedTeamId = (state: State) => state.selectedTeamId;
