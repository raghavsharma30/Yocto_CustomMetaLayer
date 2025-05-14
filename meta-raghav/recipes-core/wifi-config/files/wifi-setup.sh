#!/bin/sh

echo "Unblocking WiFi via rfkill..."
rfkill unblock wifi

i=0
while [ $i -lt 10 ]; do
  state=$(rfkill list wlan | grep 'Soft blocked' | awk '{print $3}')
  if [ "$state" = "no" ]; then
    echo "WiFi unblocked."
    break
  fi
  sleep 1
  rfkill unblock wifi
  i=$((i + 1))
done

echo "Starting wpa_supplicant..."
wpa_supplicant -B -i wlan0 -c /etc/wpa_supplicant.conf -D nl80211,wext

echo "Requesting IP via udhcpc..."
udhcpc -i wlan0
