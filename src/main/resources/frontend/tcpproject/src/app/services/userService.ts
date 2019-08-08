import {Injectable} from "@angular/core";
import { HttpClient} from "@angular/common/http";
import { User } from "../models/user";
import {environment} from "../../environments/environment";
import {Channel} from "../models/channel";
import {ChannelService} from "./channelService";


@Injectable()
export class UserService{
  public usersUrl: string;
  public sendto: string;
  public users: User[];

  //User Objects for authentication and creation
  //public authenticatedUser: User;
  public userToCreate: User;
  public userToAuthenticate: User;

  public test: Channel[];

  //SelectedUser on List
  public selectedUser: User;

  // Booleans to switch modals
  public showErrorCreatingUser = false;
  public userIsAuthenticated = false;
  public showNavBar = true;
  public newUserModal = false;
  public loginUserModal = false;

  constructor(private http: HttpClient, private channelService: ChannelService){
    this.usersUrl= environment.apiUrl + "/users";
    this.userToAuthenticate = new User;
    this.userToCreate = new User;
  }

  async findAll() {
    await this.http.get<User[]>(this.usersUrl).subscribe(data => this.users = data);

  }

  async authenticateUser(authenticatedUser:User){
    this.sendto = this.usersUrl + "/auth";
    console.log(this.userToAuthenticate.username+"1");
    const t = await this.http.post<User>(this.sendto, this.userToAuthenticate).toPromise();
    console.log(this.userToAuthenticate.username+"2");
    authenticatedUser=t;
    console.log(authenticatedUser.id+"3");
    //this.authenticatedUser = authenticatedUser;
    this.checkAuthentication(authenticatedUser);
    return t;
  }

  async createNewUser(authenticatedUser:User){
    const t = await this.http.post<User>(this.usersUrl, this.userToCreate).toPromise();
    if(t.id == -1){
      alert("Invalid username! Please use between 1 and 10 alpha numeric characters.")
      //call alert with message that says invalid characters
      return null;
    }
    if(t.id==-2){
      alert("Username already exists. Please try again!")
      //call alert with message that says user already exists
      return null;
    }
    authenticatedUser=t;
    //this.authenticatedUser = authenticatedUser;
    this.updateAuthentication(authenticatedUser);
    this.clearTextFields();
    this.updateNewUserModal()
    alert("User successfully created!")
    return t;
  }

  updateAuthentication(authenticatedUser:User){
    if(authenticatedUser.id > 0){
      this.userIsAuthenticated = true;}
  }


  checkAuthentication(authenticatedUser:User){
    if(authenticatedUser.id > 0){
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

  logOut(authenticatedUser:User){
    authenticatedUser = null;
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

   async loadChannelsAuthUser(authenticatedUser:User){
      await this.channelService.updateChannelsAfterLogin(authenticatedUser);
      authenticatedUser.channels = this.channelService.channels;
  }
  //
  // getStandardChannelsAuthUser(){
  //   console.log(this.authenticatedUser.channels);
  //
  //   return this.test;
  //   //   let stdChanCount =0;
  //   //   for(var i=0;i<this.authenticatedUser.channels.length;i++) if(!this.authenticatedUser.channels[i].direct) stdChanCount++;
  //   //   let stdChans = new Channel[stdChanCount];
  //   //   let counter=0;
  //   //   for(i=0;i<this.authenticatedUser.channels.length;i++) if(!this.authenticatedUser.channels[i].direct) stdChans[counter++]=this.authenticatedUser.channels[i];
  //   //   return stdChans;
  // }
  //
  // getDirectChannelsAuthUser(){
  //   let dirChanCount =0;
  //   for(var i=0;i<this.authenticatedUser.channels.length;i++) if(this.authenticatedUser.channels[i].direct) dirChanCount++;
  //   let dirChans = new Channel[dirChanCount];
  //   let counter=0;
  //   for(i=0;i<this.authenticatedUser.channels.length;i++) if(this.authenticatedUser.channels[i].direct) dirChans[counter++]=this.authenticatedUser.channels[i];
  //   return dirChans;
  // }


}
