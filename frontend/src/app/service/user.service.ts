import {Injectable} from "@angular/core";
import {ApiService} from "./api.service";
import {ConfigService} from "./config.service";
import {Headers, RequestOptions} from "@angular/http";
import "rxjs/add/observable/throw";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";

@Injectable()
export class UserService {
  currentUser;

  constructor(private apiService: ApiService, private config: ConfigService) {
  }

  getMyInfo(user) {
    console.log('myinfo: ' + this.currentUser + ' ' + user.username);
    var headers = new Headers();
    headers.append("Authorization", "Basic " + btoa(user.username + ":" + user.password));
    let options = new RequestOptions({headers: headers, withCredentials: true});
    return this.apiService.get(this.config.whoami_url, options)
      .map(
        u => this.currentUser = u
      );
  }

}
