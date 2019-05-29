import {
  ActionReducerMap,
  createFeatureSelector,
  createSelector,
  MetaReducer
} from '@ngrx/store';
import { environment } from '../../../environments/environment';
import { RouterReducerState, routerReducer, RouterStateSerializer } from '@ngrx/router-store';
import { Params, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';

export interface State {
  router: RouterReducerState<RouterStateUrl>;
}

export const reducers: ActionReducerMap<State> = {
  router: routerReducer
};

export interface RouterStateUrl {
  url: string;
  params: Params;
  queryParams: Params;
}

export const metaReducers: MetaReducer<State>[] = !environment.production ? [] : [];

@Injectable()
export class CustomSerializer implements RouterStateSerializer<RouterStateUrl> {
  serialize(routerState: RouterStateSnapshot): RouterStateUrl {
    let route = routerState.root;

    while (route.firstChild) {
      route = route.firstChild;
    }

    const {
      url,
      root: { queryParams }
    } = routerState;
    const { params } = route;

    return { url, params, queryParams };
  }
}

export const selectReducerState = createFeatureSelector<
  RouterReducerState<RouterStateUrl>
>('router');
export const getRouterInfo = createSelector(
  selectReducerState,
  state => state.state
);
