class Solution {
public:
    unordered_map<uint8_t, uint8_t> map;
    uint8_t reverseByte(uint8_t byte) {
        if (map.find(byte) != map.end()) return map[byte];
        uint8_t prevByte = byte;
        byte = (byte >> 4) | (byte << 4);
        byte = ((byte & 0xcc) >> 2) | ((byte & 0x33) << 2);
        byte = ((byte & 0xaa) >> 1) | ((byte & 0x55) << 1);
        map[prevByte] = byte;
        return byte;
    }
    uint32_t reverseBits(uint32_t n) {
        uint8_t bytes[4];
        uint32_t ans = 0;
        for (int i = 0; i < 4; i++) {
            bytes[i] = (n >> (i * 8)) & 0xff;
            ans = (ans << 8) | reverseByte(bytes[i]);
        }
        return ans;
    }
};
