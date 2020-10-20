import axios from "axios"
import {Device} from "@/model/Device";

class DeviceService {
    private axiosInstance: any;

    constructor() {
        this.axiosInstance = axios.create({
            baseURL: "http://localhost:8081/api", headers: {
                'Content-Type': 'application/json'
            }
        })
    }


    getAll(): Promise<Device[]> {
        return this.axiosInstance.get('/devices')

    }
}


const
    _deviceService = new DeviceService()

export default _deviceService
