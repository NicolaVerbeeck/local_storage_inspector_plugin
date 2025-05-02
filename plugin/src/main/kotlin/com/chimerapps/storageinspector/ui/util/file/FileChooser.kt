package com.chimerapps.storageinspector.ui.util.file

import com.intellij.openapi.fileChooser.*
import com.intellij.openapi.vfs.VirtualFile
import java.io.File

@Suppress("UNUSED_PARAMETER")
fun chooseSaveFile(title: String, extension: String): File? {
    val descriptor = FileSaverDescriptor(title, "")
    val dialog = FileChooserFactory.getInstance().createSaveFileDialog(descriptor, null)
    val result = dialog.save(null as VirtualFile?, null)

    return result?.file
}

fun chooseOpenFile(title: String, vararg extensions: String): VirtualFile? {

    val descriptor = if (extensions.isEmpty()) FileChooserDescriptor(
        true,
        false,
        false,
        false,
        false,
        false,
    ).withFileFilter { file -> true }.withTitle(title) else FileTypeDescriptor(title, *extensions)

    val dialog = FileChooserFactory.getInstance().createFileChooser(descriptor, null, null)
    val result = dialog.choose(null)

    return result.getOrNull(0)
}
