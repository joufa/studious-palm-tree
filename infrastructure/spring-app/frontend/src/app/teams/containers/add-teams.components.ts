import {
  ChangeDetectionStrategy,
  Component,
  OnInit,
  OnDestroy
} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { select, Store } from '@ngrx/store';
import { Observable, Subscription } from 'rxjs';
import { map } from 'rxjs/operators';
import * as fromTeams from '../../teams/reducers';
import { TeamActions } from '../actions';
import { Team, TeamDTO, TeamOperationType } from '../models/team';

@Component({
  selector: 'app-add-teams-page',
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `
    <app-add-team
      (submitted)="handleSubmit($event)"
      [team]="team$ | async"
    ></app-add-team>
  `,
  styles: [
    `
      mat-card-title {
        display: flex;
        justify-content: center;
      }
    `
  ]
})
export class AddTeamsPageComponent implements OnInit, OnDestroy {
  sub: Subscription;
  team$: Observable<Team>;
  constructor(
    private store: Store<fromTeams.State>,
    private route: ActivatedRoute
  ) {
    this.sub = route.params
      .pipe(map(params => TeamActions.selectTeam({ teamId: params.id })))
      .subscribe(action => store.dispatch(action));
    this.team$ = this.store.pipe(select(fromTeams.getSelectedTeam));
  }

  ngOnInit() {}

  handleSubmit(event: TeamDTO) {
    if (event.operation === TeamOperationType.CREATE) {
      this.store.dispatch(TeamActions.createTeam({ team: event }));
    }
    if (event.operation === TeamOperationType.UPDATE) {
      this.store.dispatch(TeamActions.updateTeam({ team: event }));
    }
    if (event.operation === TeamOperationType.DELETE) {
      this.store.dispatch(TeamActions.deleteTeam({ team: event }));
    }
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
