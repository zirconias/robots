import {Headers, RequestOptions} from "@angular/http";
import {Injectable} from "@angular/core";
import {ApiService} from "./api.service";
import {ConfigService} from "./config.service";

@Injectable()
export class RobotsService {

  constructor(private apiService: ApiService,
              private config: ConfigService) {
  }

  getRobots() {
    let headers = new Headers({
      'Accept': 'application/json'
    });
    let options = new RequestOptions({headers: headers, withCredentials: false});
    return this.apiService.get(this.config.robots_url, options);
  }

}
