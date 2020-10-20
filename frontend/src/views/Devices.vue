<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Blank</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Blank</ion-title>
        </ion-toolbar>
      </ion-header>
      <li v-for="item in devices" :key="item.id">
        <ion-text>{{ item.name }}</ion-text>
      </li>
    </ion-content>
  </ion-page>
</template>

<script type="ts">
import {defineComponent} from 'vue';
import _deviceService from "@/services/DeviceService";
import {Device} from "@/model/Device";

export default defineComponent(
    {
      data() {
        let devices;
        return {
          devices
        }
      },
      mounted() {
        _deviceService.getAll().then(devices => {
          this.devices = devices.data
        })
      },
      name: 'Devices',
      components: {}
    });

</script>
