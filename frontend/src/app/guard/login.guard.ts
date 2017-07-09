import {Injectable} from "@angular/core";
import {CanActivate, Router} from "@angular/router";


@Injectable()
export class LoginGuard implements CanActivate {

  constructor(private router: Router) {
  }

  canActivate(): boolean {
    // if (this.userService.currentUser) {
    //   this.router.navigate(['/']);
    //   return false;
    // } else {
    //   return true;
    // }
    this.router.navigate(['/']);
    return true;
  }
}
