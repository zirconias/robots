import {Injectable} from "@angular/core";
import {ConfigService} from "./config.service";
import {Headers, RequestOptions} from "@angular/http";
import {ApiService} from "./api.service";

@Injectable()
export class AuthService {
  constructor(private apiService: ApiService, private config: ConfigService) {
  }

  login(user) {
    var headers = new Headers();
    headers.append("Authorization", "Basic " + btoa(user.username + ":" + user.password));
    let options = new RequestOptions({headers: headers, withCredentials: true});
    return this.apiService.get(this.config.whoami_url, options);
  }


  logout() {
    return this.apiService.post(this.config.logout_url, {});
  }

}
