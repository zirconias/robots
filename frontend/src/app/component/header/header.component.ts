import {Component, OnInit} from "@angular/core";

import {Router} from "@angular/router";
import {AuthService} from "../../service/auth.service";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router,
              private authService: AuthService,
              private userService: UserService) {
  }

  ngOnInit() {
  }

  // logout() {
  //   this.router.navigate(['/login']);
  // }

  logout() {
    this.authService.logout().subscribe(res => {
      this.userService.currentUser = null;
      this.router.navigate(['/login']);
    });
  }

  hasSignedIn() {
    return !!this.userService.currentUser;
    //return true;
  }

  userName() {
    const user = this.userService.currentUser;
    return user.username;
  }

}
