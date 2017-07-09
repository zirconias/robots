import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";

@Injectable()
export class RobotService {
  private _username: string = 'admin';
  private _password: string = 'admin';

  constructor(private http: Http) {
  }

  getAll(): Observable<any> {
    //Basic dXNlcjp1c2Vy
    //headers.append('Authorization', 'Basic dXNlcjp1c2Vy');

    let headers = new Headers({'Accept': 'application/json'});
    //headers.append('Authorization', 'Basic dXNlcjp1c2Vy');
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append("Authorization", "Basic " + btoa(this._username + ":" + this._password));


    let options = new RequestOptions({headers: headers, withCredentials: true});

    return this.http.get('http://localhost:8080/robot', options)
      .map((response: Response) => response.json())
  }

}
