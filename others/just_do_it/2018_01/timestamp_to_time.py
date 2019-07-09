import time

t1 = '1020297600'
# localtime(sec)作用？ --- sec --> int
# 将时间戳转换成本地时间，若省略sec参数，则转换当前时间戳。
# print(time.localtime())
# time.struct_time(tm_year=2018, tm_mon=1, tm_mday=15, tm_hour=11, tm_min=20, tm_sec=23, tm_wday=0, tm_yday=15, tm_isdst=0)
# tm_isdst --> is daylight saving time 夏令时
t2 = time.localtime(int(t1))

# strftime()作用？ --- 接收时间元组，返回format格式的本地时间
# strftime(format[, t]) --- t: struct_time对象
print(time.strftime('%Y-%m-%d %H:%M:%S', t2))   # 2002-05-02 08:00:00