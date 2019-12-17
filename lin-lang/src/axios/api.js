import { get, post } from './http'

export const loginAddress = p => post('/auth/login', p)