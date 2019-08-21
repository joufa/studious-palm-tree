import { routerReducer, RouterReducerState } from '@ngrx/router-store';
import {
  ActionReducerMap,
  createFeatureSelector,
  createSelector,
  MetaReducer,
  Action
} from '@ngrx/store';
import { environment } from '../../environments/environment';
import { debug } from './meta-reducers/debug.reducer';
import * as fromLayout from './reducers/layout.reducer';
import { RouterStateUrl } from './router/router.state';
import { InjectionToken } from '@angular/core';

/** Application state */
export interface State {
  router: RouterReducerState<RouterStateUrl>;
  layout: fromLayout.State;
}

export const metaReducers: MetaReducer<State>[] = !environment.production
  ? [debug]
  : [];

export const ROOT_REDUCERS = new InjectionToken<
  ActionReducerMap<State, Action>
>('Root reducers token', {
  factory: () => ({
    layout: fromLayout.reducer,
    router: routerReducer
  })
});

// Router reducers
export const selectReducerState = createFeatureSelector<
  RouterReducerState<RouterStateUrl>
>('router');

export const getRouterInfo = createSelector(
  selectReducerState,
  state => state.state
);

// Layout reducers
export const getLayoutState = createFeatureSelector<State, fromLayout.State>(
  'layout'
);

export const getShowSidenav = createSelector(
  getLayoutState,
  fromLayout.getShowSidenav
);
