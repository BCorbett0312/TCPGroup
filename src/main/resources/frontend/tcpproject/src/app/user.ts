import { Subscription } from "./subscription";


export class User{
  id: number;
  username: string;
  password: string;
  authenticated: boolean;
  subscriptions: Subscription[];

  constructor() {
    this.password = null;
    this.authenticated = null;
  }

}
