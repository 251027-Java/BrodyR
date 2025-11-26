import { CanActivateFn } from '@angular/router';
import { Auth } from '../services/auth';
import { inject } from '@angular/core'

export const authGuardGuard: CanActivateFn = (route, state) => {
  const authService = inject(Auth)
  return authService.isAuthenticated()
};
