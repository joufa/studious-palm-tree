import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import * as fromTeams from '../../teams/reducers';
import { TeamActions } from '../actions';

@Component({
  selector: 'app-add-teams-page',
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `
    <app-add-team (submitted)="handleSubmit($event)"></app-add-team>
  `,
  styles: [`
  mat-card-title {
    display: flex;
    justify-content: center;
  }
  `]
})
export class AddTeamsPageComponent implements OnInit {


  constructor(private store: Store<fromTeams.State>) {

  }

  ngOnInit() {

  }

  handleSubmit(event: any) {
    this.store.dispatch(TeamActions.createTeam({ team: event }));
  }
}
