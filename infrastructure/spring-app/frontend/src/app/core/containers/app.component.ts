import { ChangeDetectionStrategy, Component } from '@angular/core';
import { select, Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import * as fromRoot from '../core.state';
import { LayoutActions } from '../actions';

@Component({
  selector: 'app-root',
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `
    <app-layout>
      <app-sidenav [open]="showSidenav$ | async" (closeMenu)="closeSidenav()">
        <app-nav-item
          (navigate)="closeSidenav()"
          routerLink="/"
          icon="book"
          hint="Vihje"
        >
          Tiimit
        </app-nav-item>
      </app-sidenav>
      <app-toolbar (openMenu)="openSidenav()">
        The Agile App
      </app-toolbar>
      <router-outlet></router-outlet>
    </app-layout>
  `
})
export class AppComponent {
  showSidenav$: Observable<boolean>;

  constructor(private store: Store<fromRoot.State>) {
    this.showSidenav$ = this.store.pipe(select(fromRoot.getShowSidenav));
  }

  closeSidenav() {
    this.store.dispatch(LayoutActions.closeSidenav());
  }

  openSidenav() {
    this.store.dispatch(LayoutActions.openSidenav());
  }
}
