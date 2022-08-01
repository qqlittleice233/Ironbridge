package com.qqlittleice.ironbridge.xposed.utils

import android.os.Binder
import android.os.Environment
import java.io.File
import java.security.SecureRandom
import java.util.*


/**
 * Created by fkj on 22-7-12.
 * System service get directory tool class
 */
object SystemServerDirUtils {
    private const val BASE_SERVER_DIR_NAME = "IronBridge"
    private var server_dir: File? = null
    private val baseServerDirNameLen = BASE_SERVER_DIR_NAME.length + gUID.length + 1

    private fun systemDir(): File {
        val file: File
        if (Binder.getCallingUid() == 2000) { // isShell
            file = File(File("/data/local/tmp"), "system")
            LogUtil.d("Pick dir for Shell: " + file.absolutePath)
            return file
        }
        file = File(Environment.getDataDirectory(), "system")
        LogUtil.d("Pick dir for Root: " + file.absolutePath)
        return file
    }

    private fun randomBaseServerDir(): File {
        return File(systemDir(), BASE_SERVER_DIR_NAME + "_" + gUID)
    }

    fun baseServerDir(): File {
        if (server_dir == null) {
            val findDir = findBaseServerDir()
            if (findDir == null) {
                server_dir = randomBaseServerDir()
                LogUtil.d("Create random base server dir: " + server_dir !!.absolutePath)
            } else {
                server_dir = findDir
            }
        }
        return server_dir!!
    }

    private fun findBaseServerDir(): File? {
        val files = systemDir().listFiles()
        if (files == null) {
            LogUtil.d("Can't list files in system dir: " + systemDir().absolutePath)
        }
        for (file in files !!) {
            if (file.name.startsWith(BASE_SERVER_DIR_NAME) && file.name.length == baseServerDirNameLen) {
                LogUtil.d("Found base server dir: " + file.absolutePath)
                return file
            }
        }
        LogUtil.d("No base server dir found")
        return null
    }

    /**
     * Generate a 16 bit non repeating random number, including number + Case
     * @author https://blog.csdn.net/bingguang1993/article/details/103372383
     */
    private val gUID: String
        get() {
            val uid = StringBuilder() // Generate 16 bit strong random numbers
            val rd: Random = SecureRandom()
            var i = 0
            while (i < 16) { // Generate a 3-bit random number of 0-2
                when (rd.nextInt(3)) {
                    0 ->                     // Random number of 0-9
                        uid.append(rd.nextInt(10))
                    1 ->                     // ASCII is uppercase between 65-90, get uppercase random
                        uid.append((rd.nextInt(25) + 65).toChar())
                    2 ->                     // ASCII is lowercase between 97-122, get lowercase random
                        uid.append((rd.nextInt(25) + 97).toChar())
                }
                i ++
            }
            return uid.toString()
        }

}