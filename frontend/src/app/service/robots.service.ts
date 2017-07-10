import {Headers, RequestOptions} from "@angular/http";
import {Injectable} from "@angular/core";
import {ApiService} from "./api.service";
import {ConfigService} from "./config.service";

@Injectable()
export class RobotsService {

  constructor(private apiService: ApiService,
              private config: ConfigService) {
  }

  getRobots(user) {
    let headers = new Headers();
    headers.append("Authorization", "Basic " + btoa(user._username + ":" + user._password));
    let options = new RequestOptions({headers: headers, withCredentials: true});

    return this.apiService.get(this.config.robots_url, options);
  }

}
