/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.anarres.dhcp.common.address;

import com.google.common.net.InetAddresses;
import java.net.InetAddress;
import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 *
 * @author shevek
 */
public abstract class AbstractMaskedAddress {

    private final InetAddress address;
    private final int netmask;

    public AbstractMaskedAddress(@Nonnull InetAddress address, @Nonnegative int netmask) {
        if (netmask > address.getAddress().length * Byte.SIZE)
            throw new IllegalArgumentException("Netmask too large: " + InetAddresses.toAddrString(address) + "/" + netmask);
        this.address = address;
        this.netmask = netmask;
    }

    /**
     * Returns the fundamental address.
     */
    @Nonnull
    public InetAddress getAddress() {
        return address;
    }

    @Nonnegative
    public int getNetmask() {
        return netmask;
    }

    /**
     * Returns the first address in the network, something like x.y.z.0 for large enough netmasks.
     */
    @Nonnull
    public InetAddress getNetworkAddress() {
        return AddressUtils.toNetworkAddress(getAddress(), getNetmask());
    }

    /**
     * Returns the last address in the network, something like x.y.z.255 for large enough netmasks.
     */
    @Nonnull
    public InetAddress getBroadcastAddress() {
        return AddressUtils.toBroadcastAddress(getAddress(), getNetmask());
    }

    /**
     * Returns a netmask address, something like 255.255.v.w.
     */
    @Nonnull
    public InetAddress getNetmaskAddress() {
        return AddressUtils.toNetworkMaskAddress(getAddress(), getNetmask());
    }

    @Override
    public int hashCode() {
        return getAddress().hashCode() ^ getNetmask();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (null == obj)
            return false;
        if (!getClass().equals(obj.getClass()))
            return false;
        AbstractMaskedAddress other = (AbstractMaskedAddress) obj;
        return getAddress().equals(other.getAddress())
                && getNetmask() == other.getNetmask();
    }

    @Override
    public String toString() {
        return InetAddresses.toAddrString(getAddress()) + "/" + getNetmask();
    }
}
