import { User } from '../po/User';

export interface UserDetailVO extends User {
  className?: string;
}
