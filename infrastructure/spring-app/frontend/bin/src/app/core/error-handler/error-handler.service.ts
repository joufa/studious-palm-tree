import { Injectable, ErrorHandler } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { NotificationService } from '../notifications/notifications-service';

@Injectable({ providedIn: 'root' })
export class AppErrorHandler extends ErrorHandler {
  constructor(private notificationsService: NotificationService) {
    super();
  }

  handleError(error: Error | HttpErrorResponse) {
    const message = 'Tapahtui virhe.';
    this.notificationsService.error(message);
    super.handleError(error);
  }
}
