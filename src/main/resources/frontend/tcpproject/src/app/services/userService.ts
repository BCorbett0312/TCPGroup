import {Injectable} from "@angular/core";
import { HttpClient} from "@angular/common/http";
import { User } from "../models/user";
import {environment} from "../../environments/environment";


@Injectable()
export class UserService{
  public usersUrl: string;
  public sendto: string;
  public users: User[];

  //User Objects for authentication and creation
  public authenticatedUser: User;
  public userToCreate: User;
  public userToAuthenticate: User;

  //SelectedUser on List
  public selectedUser: User;

  // Booleans to switch modals
  public showErrorCreatingUser = false;
  public userIsAuthenticated = false;
  public showNavBar = true;
  public newUserModal = false;
  public loginUserModal = false;

  constructor(private http: HttpClient){
    this.usersUrl= environment.apiUrl + "/users";
    this.userToAuthenticate = new User;
    this.userToCreate = new User;
  }

  async findAll() {
    await this.http.get<User[]>(this.usersUrl).subscribe(data => this.users = data);

  }

  async authenticateUser(){
    this.sendto = this.usersUrl + "/auth";
    const t = await this.http.post<User>(this.sendto, this.userToAuthenticate).toPromise();
    this.authenticatedUser = t;
    this.checkAuthentication();
    return t;
  }

  async createNewUser(){
    const t = await this.http.post<User>(this.usersUrl, this.userToCreate).toPromise();
    this.authenticatedUser = t;
    this.updateAuthentication();
    this.clearTextFields();
    this.updateNewUserModal()
    return t;

  }

  updateAuthentication(){
    if(this.authenticatedUser.id > 0){
      this.userIsAuthenticated = true;}
  }


  checkAuthentication(){
    if(this.authenticatedUser.id > 0){
      this.userIsAuthenticated = true;
      this.updateLoginUserModal();
    }

  }

  updateNewUserModal(){
    if(this.newUserModal === false){
      this.showNavBar = false;
      this.newUserModal = true;
    } else{
      this.newUserModal = false;
      this.showNavBar=true}
  }


  updateLoginUserModal(){
    if(this.loginUserModal === false){
      this.showNavBar = false;
      this.loginUserModal = true;
    } else{
      this.loginUserModal = false;
      this.showNavBar=true}
  }

  logOut(){
    this.authenticatedUser = null;
    this.userIsAuthenticated = false;
    this.userToAuthenticate = new User;
  }

  updateShowErrorCreatingUser(){
    if(this.showErrorCreatingUser === false){
      this.showErrorCreatingUser = true;
    } else{
      this.showErrorCreatingUser = false;}
  }

  clearTextFields(){
    this.userToCreate.username = '';
    this.userToCreate.password = '';
  }

  getUsers(){
    return this.users;
  }


}
