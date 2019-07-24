import {Injectable} from "@angular/core";
import { HttpClient} from "@angular/common/http";
import { User } from "../models/user";
import { Observable} from "rxjs";
import {environment} from "../../environments/environment";


@Injectable()
export class UserService{
  private usersUrl: string;
  sendto: string;



  constructor(private http: HttpClient){
    this.usersUrl= environment.apiUrl + "/users";
  }

  public findAll(): Observable<User[]> {
    // this.sendto = this.usersUrl + "/users";
    return this.http.get<User[]>(this.usersUrl);
  }

  async authenticateUser(user: User){
    this.sendto = this.usersUrl + "/auth/" + user.username+ "/"+ user.password;
    console.log(this.sendto);
    const t = await this.http.get<User>(this.sendto).toPromise();
    return t;
  }

  async createNewUser(user: User){
    const t = this.http.post(this.usersUrl, user).toPromise();

    return t;

  }




}