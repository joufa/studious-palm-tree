import { Component, ChangeDetectionStrategy, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { Observable } from 'rxjs';

import * as fromTeams from '../../teams/reducers';
import { Team } from '../models/team';
import { loadTeams } from '../actions/team.actions';

@Component({
    selector: 'app-view-teams-page',
    changeDetection: ChangeDetectionStrategy.OnPush,
    template: `
  jess:
    {{debug(teams$ | async)}}
  `,
})
export class TeamsPageComponent implements OnInit {
    teams$: Observable<Team[]>;

    constructor(private store: Store<fromTeams.State>) {
        this.teams$ = this.store.pipe(select(fromTeams.getAllTeams));
    }

    ngOnInit() {
        this.store.dispatch(loadTeams);
    }

    debug(a: any) {
        return JSON.stringify(a);
    }
}
