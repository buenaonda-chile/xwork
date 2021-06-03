/**
 * JavaScript for opening warning dialog.
 */

function warningDialog(display, message, formId, retryAction) {
    if (display) {
        if (confirm(message)) {
            var form = document.forms[formId];
            var warningEnable = document.createElement('input');
            warningEnable.setAttribute('type', 'hidden');
            warningEnable.setAttribute('name', 'warningBlinked');
            warningEnable.setAttribute('value', 'true');
            form.appendChild(warningEnable);
            form.action = retryAction;
            return form.submit();
        }
    }
}