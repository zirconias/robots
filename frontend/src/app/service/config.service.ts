import {Injectable} from "@angular/core";

@Injectable()
export class ConfigService {

  private _api_url = '';
  private _auth_url = '/auth';
  private _user_url = this._auth_url + '/user';
  private _whoami_url = this._user_url;
  private _login_url = this._auth_url + '/login';
  private _logout_url = this._auth_url + '/logout';

  private _robot_url = '/robot';
  private _robots_url = '/robot';

  get api_url(): string {
    return this._api_url;
  }

  get auth_url(): string {
    return this._auth_url;
  }

  get user_url(): string {
    return this._user_url;
  }

  get whoami_url(): string {
    return this._whoami_url;
  }

  get login_url(): string {
    return this._login_url;
  }

  get logout_url(): string {
    return this._logout_url;
  }

  get robot_url(): string {
    return this._robot_url;
  }

  get robots_url(): string {
    return this._robots_url;
  }
}
