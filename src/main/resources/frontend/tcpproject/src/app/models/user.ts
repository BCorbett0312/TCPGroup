import {Channel} from "./channel";

export class User{
  id: number;
  username: string;
  password: string;
  channels: Channel[];


  constructor(){
    this.password = null;

  }

}
