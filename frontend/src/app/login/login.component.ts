import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
// import {UserService} from "../service/user.service";
import {AuthService} from "../service/auth.service";
import {Router} from "@angular/router";

import "rxjs/add/observable/throw";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import "rxjs";
import "rxjs/add/observable/interval";
import {UserService} from "../service/user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  title = 'Login';
  form: FormGroup;
  authForm;

  submitted = false;

  errorDiagnostic: string;

  constructor(private authService: AuthService,
              private userService: UserService,
              private router: Router, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.form = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      password: ['', Validators.compose([Validators.required, Validators.minLength(3)])]
    });
  }

  onSubmit() {
    this.submitted = true;
    this.errorDiagnostic = null;

    let formObj = this.form.getRawValue();
    this.authService.login(formObj).delay(1000)
      .subscribe(data => {
          this.authForm = formObj;
          console.log('loginResponse: ' + JSON.stringify(data));
          this.userService.getMyInfo(formObj).subscribe();
          this.router.navigate(['/']);
        },
        error => {
          this.submitted = false;
          this.errorDiagnostic = 'incorrect username or password';
        });
  }

}
