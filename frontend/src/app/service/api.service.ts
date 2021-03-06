import {Injectable} from "@angular/core";
import {Headers, Http, RequestMethod, RequestOptions, Response} from "@angular/http";


import {Observable} from "rxjs/Observable";
import "rxjs/add/observable/throw";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";

@Injectable()
export class ApiService {

  headers = new Headers({
    'Accept': 'application/json'
  });

  constructor(private http: Http) {
  }

  anonGet(path: string): Observable<any> {
    return this.http.get(
      path, {
        headers: this.headers,
        withCredentials: true
      }
    )
      .map(ApiService.extractData);
  }

  get(path: string, options: RequestOptions): Observable<any> {
    console.log('path: ' + path + ' ' + 'request options:' + JSON.stringify(options));
    return this.http.get(
      path,
      options
    )
      .map(ApiService.extractData)
      .catch(ApiService.checkAuth.bind(this));
  }

  post(path: string, body, customHeaders?, put?): Observable<any> {
    return this.http.request(
      path,
      {
        method: put ? RequestMethod.Put : RequestMethod.Post,
        body: body,
        headers: customHeaders || this.headers,
        withCredentials: true
      }
    ).map(ApiService.extractData)
      .catch(ApiService.checkAuth.bind(this));
  }

  put(path: string, body: any): Observable<any> {
    return this.post(path, body, true);
  }


  private static extractData(res: Response) {
    const body = res.json();
    console.log('body::' + JSON.stringify(body));
    return body || {};
  }

  private static checkAuth(error: any) {
    if (error && error.status === 401) {
      console.log(401);
    } else {
    }
    throw error;
  }
}
